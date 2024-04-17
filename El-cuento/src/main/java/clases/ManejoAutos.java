package clases;

/**
 *
 * @author Manuel
 */

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ManejoAutos {
    
    String archivo = "datos.txt";
    
    ArrayList<String> marcas = new ArrayList<>();
    ArrayList<String> clases;
    ArrayList<String> servicios;
    ArrayList<String> referencias;
    ArrayList<String> anos;
    
    Auto vehiculo;
    
    public ArrayList<String> buscarMarcas(){
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datosAuto = linea.split("\t");
                boolean yaEsta = false;
                for (String marca : marcas){
                    if(marca.equals(datosAuto[0])){
                        yaEsta = true;
                    }
                }
                if(!yaEsta){
                    marcas.add(datosAuto[0]);
                }
            }   
        } catch (IOException e){
        }
        return marcas;
    }
    
    public ArrayList<String> buscarClases(String marca){
        clases = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datosAuto = linea.split("\t");
                if(datosAuto[0].equals(marca)){
                    boolean yaEsta = false;
                    for (String clase : clases){
                        if(clase.equals(datosAuto[1])){
                            yaEsta = true;
                        }
                    }
                    if(!yaEsta){
                        clases.add(datosAuto[1]);
                    }
                }
            }   
        } catch (IOException e){
        }
        return clases;
    }
    
    public ArrayList<String> buscarServicios(String marca, String clase){
        servicios = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datosAuto = linea.split("\t");
                if(datosAuto[0].equals(marca) && datosAuto[1].equals(clase)){
                    boolean yaEsta = false;
                    for (String servicio : servicios){
                        if(servicio.equals(datosAuto[7])){
                            yaEsta = true;
                        }
                    }
                    if(!yaEsta){
                        servicios.add(datosAuto[7]);
                    }
                }
            }   
        } catch (IOException e){
        }
        return servicios;
    }
    
    public ArrayList<String> buscarReferencias(String marca, String clase, String servicio){
        referencias = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datosAuto = linea.split("\t");
                if(datosAuto[0].equals(marca) && datosAuto[1].equals(clase) && datosAuto[7].equals(servicio)){
                    String referencia = datosAuto[3] + " " + datosAuto[4] + " " + datosAuto[5];
                    referencias.add(referencia);
                }
            }   
        } catch (IOException e){
        }
        return referencias;
    }
    
    public ArrayList<String> buscarAnos(String marca, String clase, String servicio, String referencia){
        anos = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datosAuto = linea.split("\t");
                if(datosAuto[0].equals(marca) && datosAuto[1].equals(clase) && datosAuto[7].equals(servicio) && 
                        (datosAuto[3] + " " + datosAuto[4] + " " + datosAuto[5]).equals(referencia)){
                    for(int i = 8; i < 62; i++){
                        if(!datosAuto[i].equals("0")){
                            anos.add((i+1962)+"");
                        }
                    }
                }
            }   
        } catch (IOException e){
        }
        return anos;
    }
    
    public Auto buscarAuto(String marca, String clase, String servicio, String referencia, String ano){
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datosAuto = linea.split("\t");
                if(datosAuto[0].equals(marca) && datosAuto[1].equals(clase) && datosAuto[7].equals(servicio) && 
                        (datosAuto[3] + " " + datosAuto[4] + " " + datosAuto[5]).equals(referencia)){
                    vehiculo = new Auto(marca, referencia, datosAuto[2], datosAuto[6], datosAuto[Integer.valueOf(ano)-1962], datosAuto[62], datosAuto[63], 
                            datosAuto[64], datosAuto[65], datosAuto[66], datosAuto[67], datosAuto[68], datosAuto[69], datosAuto[70]);
                }
            }   
        } catch (IOException e){
        }
        return vehiculo;
    }
    
    public Auto buscarPorCodigo(String codigo, String ano){
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datosAuto = linea.split("\t");
                if(datosAuto[2].equals(codigo)){
                    vehiculo = new Auto(datosAuto[0], (datosAuto[3] + " " + datosAuto[4] + " " + datosAuto[5]), datosAuto[2], datosAuto[6], datosAuto[Integer.valueOf(ano)-1962], datosAuto[62], datosAuto[63], 
                            datosAuto[64], datosAuto[65], datosAuto[66], datosAuto[67], datosAuto[68], datosAuto[69], datosAuto[70]);
                }
            }   
        } catch (IOException e){
        }
        return vehiculo;
    }
}
