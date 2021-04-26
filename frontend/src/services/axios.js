import axios from "axios";

const instance = axios.create({
  baseURL: 'http://unirep.website'
});

export default instance;