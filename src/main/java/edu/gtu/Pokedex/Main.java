package edu.gtu.Pokedex;

import edu.gtu.Pokedex.domain.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Main {

    private static ImageIcon scale(String url, int w, int h) throws Exception {
        Image img = new ImageIcon(new URL(url)).getImage();
        return new ImageIcon(img.getScaledInstance(w, h, Image.SCALE_SMOOTH));
    }

    public static void main(String[] args) {
        Repository repository = new Repository();

        JFrame frame = new JFrame("PokeDex");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(820, 480);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("src/main/resources/Poké_Ball_icon.svg.png");
        frame.setIconImage(icon.getImage());

        JPanel headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(820, 55));
        headerPanel.setBackground(new Color(220, 20, 60));

        JLabel title = new JLabel("Java PokeDex");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Verdana", Font.BOLD, 18));
        headerPanel.add(title);

        JPanel leftPanel = new JPanel(null);
        leftPanel.setPreferredSize(new Dimension(200, 425));
        leftPanel.setBackground(new Color(245, 245, 245));

        JLabel idLabel = new JLabel("Pokemon ID");
        idLabel.setBounds(30, 60, 120, 20);
        leftPanel.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(30, 85, 140, 28);
        leftPanel.add(idField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(30, 130, 140, 32);
        searchButton.setBackground(new Color(220, 20, 60));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        leftPanel.add(searchButton);

        JPanel centerPanel = new JPanel(null);
        centerPanel.setBackground(Color.WHITE);

        JTextArea pokemonInfo = new JTextArea();
        pokemonInfo.setBounds(15, 15, 330, 360);
        pokemonInfo.setEditable(false);
        pokemonInfo.setLineWrap(true);
        pokemonInfo.setWrapStyleWord(true);
        pokemonInfo.setFont(new Font("Verdana", Font.PLAIN, 12));
        pokemonInfo.setBorder(BorderFactory.createTitledBorder("Info"));
        centerPanel.add(pokemonInfo);

        JPanel imagePanel = new JPanel(null);
        imagePanel.setPreferredSize(new Dimension(220, 425));
        imagePanel.setBackground(Color.WHITE);

        JLabel frontImage = new JLabel();
        frontImage.setBounds(35, 20, 150, 150);
        frontImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        imagePanel.add(frontImage);

        JLabel backImage = new JLabel();
        backImage.setBounds(35, 190, 150, 150);
        backImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        imagePanel.add(backImage);

        searchButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                Pokemon pokemon = repository.getPokemonById(id);
                pokemonInfo.setText(pokemon.toString());
                frontImage.setIcon(scale(pokemon.getFront_image(), 150, 150));
                backImage.setIcon(scale(pokemon.getBack_image(), 150, 150));
            } catch (Exception ex) {
                pokemonInfo.setText("Invalid ID");
                frontImage.setIcon(null);
                backImage.setIcon(null);
            }
        });

        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(imagePanel, BorderLayout.EAST);

        frame.setVisible(true);
    }
}
