import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../models/task.model';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  private apiUrl = 'http://localhost:8080/api/tasks'; // Update with your Spring Boot URL

  constructor(private http: HttpClient) {}

  getAllTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiUrl}/all`);
  }

  getTasksForUser(userId: number): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiUrl}/user_tasks`, {
      params: new HttpParams().set('userId', userId.toString()),
    });
  }

  getTaskById(id: number): Observable<Task> {
    return this.http.get<Task>(`${this.apiUrl}/${id}`);
  }

  createTask(task: Task): Observable<Task> {
    return this.http.post<Task>(this.apiUrl, task);
  }

  updateTask(id: number, task: Task): Observable<Task> {
    return this.http.put<Task>(`${this.apiUrl}/${id}`, task);
  }

  deleteTask(id: number): Observable<boolean> {
    return this.http.delete<boolean>(`${this.apiUrl}/${id}`);
  }

  filterTasks(title?: string, status?: string): Observable<Task[]> {
    let params = new HttpParams();
    if (title) {
      params = params.set('title', title);
    }
    if (status) {
      params = params.set('status', status);
    }
    return this.http.get<Task[]>(`${this.apiUrl}/filter`, { params });
  }

  filterTasksForUser(
    title?: string,
    status?: string,
    userId?: number
  ): Observable<Task[]> {
    let params = new HttpParams();
    if (title) {
      params = params.set('title', title);
    }
    if (status) {
      params = params.set('status', status);
    }
    if (userId) {
      params = params.set('userId', userId.toString());
    }
    return this.http.get<Task[]>(`${this.apiUrl}/filter_user`, { params });
  }
}
