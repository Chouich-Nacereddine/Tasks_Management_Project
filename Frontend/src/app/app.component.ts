import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { NgIf } from '@angular/common';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    CommonModule,
    NgIf,
    RouterModule,
  ],
  templateUrl: './app.component.html',
})
export class AppComponent implements OnInit {
  title = 'Login';
  email = '';
  password = '';
  errorMessage = '';

  constructor(protected authService: AuthService, private router: Router) {}

  // This runs when the component is initialized
  ngOnInit(): void {
    // Check if the user is authenticated
    if (this.authService.isAuthenticated()) {
      // Redirect to user or admin page based on the role
      const userRole = this.authService.getUserRole();
      if (userRole === 'ADMIN') {
        this.router.navigate(['/admin']);
      } else {
        this.router.navigate(['/user']);
      }
    }
  }

  login() {
    this.authService.login(this.email, this.password).subscribe({
      next: (response) => {
        // Store the token after successful login
        this.authService.storeToken(response.token);
        this.authService.storeRole(response.role);

        // Redirect to the appropriate page based on the user's role
        const userRole = this.authService.getUserRole();
        console.log(userRole);
        if (userRole === 'ADMIN') {
          this.router.navigate(['/admin']);
        } else {
          this.router.navigate(['/user']);
        }
      },
      error: () => {
        this.errorMessage = 'Incorrect Email or Password! Please try again.';
      },
    });
  }
}
