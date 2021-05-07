/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.climaregist.presenter.Adapter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tarci
 */
public class ImpressoraXml {

    private final Path currentRelativePath = Paths.get("");
    private final String path = currentRelativePath.toAbsolutePath().toString();

    public void imprimir(String impressao) throws IOException {

        try {
            FileWriter fileWriter = new FileWriter(path + "/src/main/java/outputxml.xml", true);
            fileWriter.write(impressao);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(ImpressoraXml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
