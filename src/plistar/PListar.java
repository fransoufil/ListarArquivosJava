/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plistar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author franz
 */
public class PListar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        createWindow();

    }

    private static void createWindow() {

        JFrame frame = new JFrame("Escolher Diretorio de Arquivos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(400, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createUI(final JFrame frame) {

        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);

        JButton button = new JButton("Escolha a pasta/diretório aqui!");
        final JLabel label = new JLabel();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showOpenDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    //File file = fileChooser.getCurrentDirectory();
                    //label.setText("Folder Selected: " + file.getName());
                    label.setText("Diretório selecionado: " + file.getAbsolutePath());

                    String path = file.getAbsolutePath();

                    File diretorio = new File(path);

                    File[] arquivos = diretorio.listFiles();

                    for (File arquivo : arquivos) {
                        System.out.println(arquivo);
                    }
                } else {
                    label.setText("Escolha cancelada");
                }
            }
        });

        panel.add(button);
        panel.add(label);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

}
