package infinityshopping.online.app.web.rest;

import infinityshopping.online.app.repository.StoreRepository;
import infinityshopping.online.app.service.StoreService;
import infinityshopping.online.app.service.dto.StoreDTO;
import infinityshopping.online.app.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link infinityshopping.online.app.domain.Store}.
 */
@RestController
@RequestMapping("/api/stores")
public class StoreResource {

    private static final Logger LOG = LoggerFactory.getLogger(StoreResource.class);

    private static final String ENTITY_NAME = "infinityShoppingStoreStore";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StoreService storeService;

    private final StoreRepository storeRepository;

    public StoreResource(StoreService storeService, StoreRepository storeRepository) {
        this.storeService = storeService;
        this.storeRepository = storeRepository;
    }

    /**
     * {@code POST  /stores} : Create a new store.
     *
     * @param storeDTO the storeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new storeDTO, or with status {@code 400 (Bad Request)} if the store has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<StoreDTO> createStore(@Valid @RequestBody StoreDTO storeDTO) throws URISyntaxException {
        LOG.debug("REST request to save Store : {}", storeDTO);
        if (storeDTO.getId() != null) {
            throw new BadRequestAlertException("A new store cannot already have an ID", ENTITY_NAME, "idexists");
        }
        storeDTO = storeService.save(storeDTO);
        return ResponseEntity.created(new URI("/api/stores/" + storeDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, storeDTO.getId().toString()))
            .body(storeDTO);
    }

    /**
     * {@code PUT  /stores/:id} : Updates an existing store.
     *
     * @param id the id of the storeDTO to save.
     * @param storeDTO the storeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated storeDTO,
     * or with status {@code 400 (Bad Request)} if the storeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the storeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<StoreDTO> updateStore(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody StoreDTO storeDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update Store : {}, {}", id, storeDTO);
        if (storeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, storeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!storeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        storeDTO = storeService.update(storeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, storeDTO.getId().toString()))
            .body(storeDTO);
    }

    /**
     * {@code PATCH  /stores/:id} : Partial updates given fields of an existing store, field will ignore if it is null
     *
     * @param id the id of the storeDTO to save.
     * @param storeDTO the storeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated storeDTO,
     * or with status {@code 400 (Bad Request)} if the storeDTO is not valid,
     * or with status {@code 404 (Not Found)} if the storeDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the storeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<StoreDTO> partialUpdateStore(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody StoreDTO storeDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update Store partially : {}, {}", id, storeDTO);
        if (storeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, storeDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!storeRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<StoreDTO> result = storeService.partialUpdate(storeDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, storeDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /stores} : get all the stores.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stores in body.
     */
    @GetMapping("")
    public List<StoreDTO> getAllStores() {
        LOG.debug("REST request to get all Stores");
        return storeService.findAll();
    }

    /**
     * {@code GET  /stores/:id} : get the "id" store.
     *
     * @param id the id of the storeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the storeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> getStore(@PathVariable("id") Long id) {
        LOG.debug("REST request to get Store : {}", id);
        Optional<StoreDTO> storeDTO = storeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(storeDTO);
    }

    /**
     * {@code DELETE  /stores/:id} : delete the "id" store.
     *
     * @param id the id of the storeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete Store : {}", id);
        storeService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
