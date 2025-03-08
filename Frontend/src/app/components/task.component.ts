import { Component } from '@angular/core';
import { TaskService } from '../services/task.service';
import { Task } from '../models/task.model';
import { inject } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-task',
  standalone: true,
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css'],
  providers: [TaskService, CommonModule],
})
export class TaskComponent {
  tasks: Task[] = [];
  userTasks: Task[] = [];
  errorMessage: string = '';

  taskService = inject(TaskService); // Inject TaskService

  ngOnInit(): void {
    this.loadAllTasks();
  }

  loadAllTasks(): void {
    this.taskService.getAllTasks().subscribe(
      (tasks) => {
        this.tasks = tasks;
      },
      (error) => {
        this.errorMessage = 'Error loading tasks!';
        console.error(error);
      }
    );
  }

  loadUserTasks(userId: number): void {
    this.taskService.getTasksForUser(userId).subscribe(
      (tasks) => {
        this.userTasks = tasks;
      },
      (error) => {
        this.errorMessage = `Error loading tasks for user with ID ${userId}`;
        console.error(error);
      }
    );
  }

  createTask(): void {
    const newTask: Task = {
      id: 0,
      title: 'New Task',
      description: 'Description of the new task',
      status: 'NOT_STARTED',
      userInCharge: { id: 1, username: 'user1' },
    };

    this.taskService.createTask(newTask).subscribe(
      (task) => {
        this.tasks.push(task);
      },
      (error) => {
        this.errorMessage = 'Error creating task!';
        console.error(error);
      }
    );
  }
}
