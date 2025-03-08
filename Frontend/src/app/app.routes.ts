import { Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AdminComponent } from './components/admin/admin.component';
import { UserComponent } from './components/user/user.component';
import { AuthGuard } from './guards/auth.guard';

export const routes: Routes = [
  { path: 'admin', component: AdminComponent, canActivate: [AuthGuard] }, // Protecting the admin route
  { path: 'user', component: UserComponent, canActivate: [AuthGuard] }, // Protecting the user route
  { path: '**', redirectTo: '' },
];
