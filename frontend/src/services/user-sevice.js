import { myAxios } from "./helper";

export const signUp=(user)=>{
    return myAxios.post('/api/n1/auth/register',user)
    .then((response)=>response.json())
}