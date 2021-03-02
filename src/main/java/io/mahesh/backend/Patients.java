/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.mahesh.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
   
@Entity 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patients {
    @Id 
    @GeneratedValue   
    private int id;
    private String Name; 
    private String Email;
    private String Phone;
    private String Illness;
    private String Doctor;
    private String Date;
   
}  