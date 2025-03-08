export interface Task {
  id: number;
  title: string;
  description: string;
  status: string; // Task status, you can keep it as a string or use an enum
  userInCharge: {
    id: number;
    username: string;
  };
}
