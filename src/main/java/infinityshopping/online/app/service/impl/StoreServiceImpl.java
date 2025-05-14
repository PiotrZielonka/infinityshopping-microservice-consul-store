package infinityshopping.online.app.service.impl;

import infinityshopping.online.app.domain.Store;
import infinityshopping.online.app.repository.StoreRepository;
import infinityshopping.online.app.service.StoreService;
import infinityshopping.online.app.service.dto.StoreDTO;
import infinityshopping.online.app.service.mapper.StoreMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link infinityshopping.online.app.domain.Store}.
 */
@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    private static final Logger LOG = LoggerFactory.getLogger(StoreServiceImpl.class);

    private final StoreRepository storeRepository;

    private final StoreMapper storeMapper;

    public StoreServiceImpl(StoreRepository storeRepository, StoreMapper storeMapper) {
        this.storeRepository = storeRepository;
        this.storeMapper = storeMapper;
    }

    @Override
    public StoreDTO save(StoreDTO storeDTO) {
        LOG.debug("Request to save Store : {}", storeDTO);
        Store store = storeMapper.toEntity(storeDTO);
        store = storeRepository.save(store);
        return storeMapper.toDto(store);
    }

    @Override
    public StoreDTO update(StoreDTO storeDTO) {
        LOG.debug("Request to update Store : {}", storeDTO);
        Store store = storeMapper.toEntity(storeDTO);
        store = storeRepository.save(store);
        return storeMapper.toDto(store);
    }

    @Override
    public Optional<StoreDTO> partialUpdate(StoreDTO storeDTO) {
        LOG.debug("Request to partially update Store : {}", storeDTO);

        return storeRepository
            .findById(storeDTO.getId())
            .map(existingStore -> {
                storeMapper.partialUpdate(existingStore, storeDTO);

                return existingStore;
            })
            .map(storeRepository::save)
            .map(storeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StoreDTO> findAll() {
        LOG.debug("Request to get all Stores");
        return storeRepository.findAll().stream().map(storeMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StoreDTO> findOne(Long id) {
        LOG.debug("Request to get Store : {}", id);
        return storeRepository.findById(id).map(storeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Store : {}", id);
        storeRepository.deleteById(id);
    }
}
