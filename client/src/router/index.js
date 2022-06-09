import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import NotFound from '../views/NotFound.vue';
import Destinations from '../views/destinations/Destinations.vue';
import SingleDestination from '../views/destinations/SingleDestination.vue';
import Admin from '../views/admin/Admin.vue';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/admin',
    name: 'Admin',
    component: Admin,
  },
  {
    path: '/destinations',
    name: 'Destinations',
    component: Destinations,
  },
  {
    path: '/destinations/:id',
    name: 'SingleDestination',
    component: SingleDestination,
    props: true,
  },
  {
    path: '/:catchAll(.*)',
    name: 'NotFound',
    component: NotFound,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
