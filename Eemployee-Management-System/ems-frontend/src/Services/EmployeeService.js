import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api/employee";
export const listEmployees = () => axios.get(REST_API_BASE_URL);

export const creatEmployee = (employee) =>
  axios.post(REST_API_BASE_URL, employee);

export const getEmployee = (employeeId) =>
  axios.get(REST_API_BASE_URL + "/" + employeeId);
export const updateEmployee = (empId, employee) =>
  axios.put(REST_API_BASE_URL + "/" + empId, employee);
export const deleteEmployee = (employeeId) =>
  axios.delete(REST_API_BASE_URL + "/" + employeeId);
