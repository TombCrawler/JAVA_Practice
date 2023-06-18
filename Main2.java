import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.midi.*;

class NotePlayer extends JFrame implements ActionListener {
    private Synthesizer synthesizer;
    private MidiChannel[] midiChannels;

    NotePlayer() {
        super("Note Player");

        // Define the musical notes for each instrument as strings
        String[] pianoNotes = {"C", "D", "E", "F", "G", "A", "B"};
        String[] violinNotes = {"G", "A", "B", "C", "D", "E", "F#"};
        String[] saxophoneNotes = {"D", "E", "F#", "G", "A", "B", "C#"};
        

        
        // Create panels for each instrument
        JPanel pianoPanel = createButtonPanel(pianoNotes, 0);
        JPanel violinPanel = createButtonPanel(violinNotes, 1);
        JPanel saxophonePanel = createButtonPanel(saxophoneNotes, 2);

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

        // Add the instrument panels to the frame
        add(pianoPanel, BorderLayout.NORTH);
        add(violinPanel, BorderLayout.CENTER);
        add(saxophonePanel, BorderLayout.SOUTH);

        // Configure the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createButtonPanel(String[] notes, int channel) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, notes.length));
        JButton[] buttons = new JButton[notes.length];
        for (int i = 0; i < notes.length; i++) {
            buttons[i] = new JButton(notes[i]);
            buttons[i].setActionCommand(String.valueOf(i)); // Use the index as the action command
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }
        buttonPanel.putClientProperty("channel", channel); // Store the channel number as client property
        return buttonPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the source of the button click
        JButton source = (JButton) e.getSource();

        // Get the note value based on the button's action command (index)
        int noteIndex = Integer.parseInt(source.getActionCommand());

        // Get the channel number from the button panel's client property
        int channel = (int) ((JPanel) source.getParent()).getClientProperty("channel");

        // Play the corresponding note on the specified channel
        playNoteOnChannel(midiChannels[channel], noteIndex);
    }

    private void playNoteOnChannel(MidiChannel midiChannel, int noteIndex) {
        // Get the note value based on the index
        int noteValue = getNoteValue(noteIndex);

        // Play the note for a duration of 500 milliseconds
        midiChannel.noteOn(noteValue, 80);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        midiChannel.noteOff(noteValue);
    }

    private int getNoteValue(int noteIndex) {
        // Map the note index to its corresponding MIDI note value
        switch (noteIndex) {
            case 0:
                return 60; // C
            case 1:
                return 62; // D
            case 2:
                return 64; // E
            case 3:
                return 65; // F
            case 4:
                return 67; // G
            case 5:
                return 69; // A
            case 6:
                return 71; // B
            default:
                return -1;
        }
    }

    private void setInstruments() {
        // Set the instruments for each channel
        // Piano: Channel 0, Violin: Channel 1, Saxophone: Channel 2
        midiChannels[0].programChange(0); // Piano instrument
        midiChannels[1].programChange(41); // Violin instrument
        midiChannels[2].programChange(65); // Saxophone instrument
    }
}

public class Main2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(NotePlayer::new);
    }
}
