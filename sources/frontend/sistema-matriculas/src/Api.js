import axios from "axios";

const API_URL = "http://localhost:8080/students"; // URL base da API

// Cria um novo estudante
export const createStudent = async (student) => {
  try {
    const response = await axios.post(API_URL, student);
    return response.data;
  } catch (error) {
    console.error("Erro ao criar estudante", error);
    throw error;
  }
};

// Busca um estudante por ID
export const getStudentById = async (id) => {
  try {
    const response = await axios.get(`${API_URL}/${id}`);
    return response.data;
  } catch (error) {
    console.error("Erro ao buscar estudante", error);
    throw error;
  }
};

// Atualiza um estudante
export const updateStudent = async (id, student) => {
  try {
    const response = await axios.put(`${API_URL}/${id}`, student);
    return response.data;
  } catch (error) {
    console.error("Erro ao atualizar estudante", error);
    throw error;
  }
};

// Deleta um estudante
export const deleteStudent = async (id) => {
  try {
    await axios.delete(`${API_URL}/${id}`);
  } catch (error) {
    console.error("Erro ao deletar estudante", error);
    throw error;
  }
};

// Busca todos os estudantes
export const getAllStudents = async () => {
  try {
    const response = await axios.get(API_URL);
    return response.data;
  } catch (error) {
    console.error("Erro ao buscar todos os estudantes", error);
    throw error;
  }
};
