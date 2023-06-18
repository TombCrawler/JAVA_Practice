import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.midi.*;

class NotePlayer extends JFrame implements ActionListener {
    private JButton[] noteButtons;
    private Synthesizer synthesizer;
    private MidiChannel[] midiChannels;

    NotePlayer() {
        super("Note Player");

        // Define the musical notes as strings
        String[] notes = {"C", "D", "E", "F", "G", "A", "B"};

        // Create an array of buttons for each note
        noteButtons = new JButton[notes.length];

        // Initialize the MIDI synthesizer and channels
        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            midiChannels = synthesizer.getChannels();
            setInstruments(); // Set the default instruments
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Create and configure the GUI components
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, notes.length));
        for (int i = 0; i < notes.length; i++) {
            noteButtons[i] = new JButton(notes[i]);
            noteButtons[i].addActionListener(this);
            buttonPanel.add(noteButtons[i]);
        }

        // Add the button panel to the frame
        add(buttonPanel);

        // Configure the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 100);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the source of the button click
        JButton source = (JButton) e.getSource();

        // Get the note value based on the button's text
        int noteValue = getNoteValue(source.getText());

        // Play the corresponding note on all channels
        for (MidiChannel midiChannel : midiChannels) {
            playNoteOnChannel(midiChannel, noteValue);
        }
    }

    private int getNoteValue(String note) {
        // Map the note name to its corresponding MIDI note value
        switch (note) {
            case "C":
                return 60;
            case "D":
                return 62;
            case "E":
                return 64;
            case "F":
                return 65;
            case "G":
                return 67;
            case "A":
                return 69;
            case "B":
                return 71;
            default:
                return -1;
        }
    }

    private void playNoteOnChannel(MidiChannel midiChannel, int noteValue) {
        // Play the note for a duration of 500 milliseconds
        midiChannel.noteOn(noteValue, 80);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        midiChannel.noteOff(noteValue);
    }

    private void setInstruments() {
        // Set the instruments for each channel
        for (int i = 0; i < midiChannels.length; i++) {
            midiChannels[i].programChange(i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(NotePlayer::new);
    }
}
