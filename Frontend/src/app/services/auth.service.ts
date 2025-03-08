import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/auth/login';

  // Check if we're in the browser environment
  private isBrowser =
    typeof window !== 'undefined' && typeof window.localStorage !== 'undefined';

  constructor(private http: HttpClient) {}

  login(email: string, password: string): Observable<any> {
    return this.http.post<any>(this.apiUrl, { email, password });
  }

  storeToken(token: string): void {
    if (this.isBrowser) {
      localStorage.setItem('jwtToken', token);
    }
  }

  getToken(): string | null {
    if (this.isBrowser) {
      return localStorage.getItem('jwtToken');
    }
    return null;
  }

  isAuthenticated(): boolean {
    if (this.isBrowser) {
      return this.getToken() !== null;
    }
    return false;
  }

  storeRole(role: string): void {
    if (this.isBrowser) {
      localStorage.setItem('userRole', role);
    }
  }
  getUserRole(): string {
    if (this.isBrowser) {
      return localStorage.getItem('userRole') || '';
    }
    return '';
  }

  logout(): void {
    if (this.isBrowser) {
      localStorage.removeItem('jwtToken');
      localStorage.removeItem('userRole');
    }
  }
}
