#### Asignatura: *APAW. ECP2. Arquitecturas y Patrones Web*
#### [Máster en Ingeniería Web por la U.P.M.](http://miw.etsisi.upm.es)

## Estado del código

[![Build Status](https://travis-ci.org/dpb-upm/APAW.ECP2.DanielPerez.svg?branch=develop)](https://travis-ci.org/dpb-upm/APAW.ECP2.DanielPerez)

![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=es.upm.miw%3AAPAW.ECP2.DanielPerez&metric=alert_status)

## Tecnologías necesarias
* Java
* Maven
* GitHub
* Travis-ci
* Sonarcloud

## Diseño de entidades

![alt text](https://github.com/dpb-upm/APAW.ECP2.DanielPerez/blob/master/src/documentacion/uml_diagram_base.jpg)

## API

### POST /servidor

Crea un servidor:

#### Parámetros del cuerpo
  <ul>
    <li>tipo: TipoServidor (<b>requerido</b>)</li>
  </ul>
  
#### Respuesta
  <ul>
  <li>200 OK</li>
    <ul>
      <li>id: String</li>
    </ul>
  <li>403 BAD_REQUEST</li>
  </ul>
  
### POST /propietario
  
  Crea un propietario
  
#### Parámetros del cuerpo
  <ul>
    <li>nombre: String (<b>requerido</b>)</li>
    <li>edad: float (<b>requerido</b>)</li>
    <li>fecha_nacimiento: Localdatetime (<b>requerido</b>)</li>
   </ul>
     
#### Respuesta
  <ul>
  <li>200 OK</li>
    <ul>
      <li>id: String</li>
    </ul>
  <li>403 BAD_REQUEST</li>
  </ul>

### GET /propietario/{id}

Obtiene a un propietario por id

#### Respuesta
  <ul>
  <li>200 OK</li>
    <ul>
      <li>id: String</li>
    </ul>
  <li>403 BAD_REQUEST</li>
  </ul>
  
 ### PUT /propietario/{id}
 
 Actualiza la id de un propietario

#### Respuesta
  <ul>
  <li>200 OK</li>
  <li>403 BAD_REQUEST</li>
  </ul>