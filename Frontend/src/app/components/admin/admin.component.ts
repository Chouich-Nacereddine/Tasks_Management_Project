import { ChangeDetectionStrategy, Component, signal } from '@angular/core';
import { MatExpansionModule } from '@angular/material/expansion';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { TaskComponent } from '../task.component'; // Import TaskComponent

interface Status {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'Admin',
  imports: [
    MatExpansionModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    FormsModule,
    TaskComponent,
  ],
  changeDetection: ChangeDetectionStrategy.OnPush,

  standalone: true,
  templateUrl: './admin.component.html',
})
export class AdminComponent {
  readonly panelOpenState = signal(false);
  status: Status[] = [
    { value: 'NOT_STARTED', viewValue: 'NOT STARTED' },
    { value: 'IN_PROGRESS', viewValue: 'IN PROGRESS' },
    { value: 'DONE', viewValue: 'DONE' },
  ];
}
