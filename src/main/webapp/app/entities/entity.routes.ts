import { Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'store',
    data: { pageTitle: 'infinityShoppingStoreApp.infinityShoppingStoreStore.home.title' },
    loadChildren: () => import('./InfinityShoppingStore/store/store.routes'),
  },
  /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
];

export default routes;
