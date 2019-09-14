import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.UnitGenerator;
import com.jsyn.unitgen.UnitVoice;
import com.softsynth.shared.time.TimeStamp;

import java.util.Scanner;

public class MelodyGenerator {
    Synthesizer synth;
    UnitGenerator ugen;
    UnitVoice voice;
    LineOut lineOut;
    double timeNow;
    double freq; // hertz
    double duration = 1.4;
    double onTime = 1.0;

    TimeStamp timeStamp = new TimeStamp(0);

    public void playA(){
        freq = 220.00;
        voice.noteOn(freq, 0.5, timeStamp);
        voice.noteOff(timeStamp.makeRelative(onTime));
    }

    public void playB(){
        freq = 246.94;
        voice.noteOn(freq, 0.5, timeStamp);
        voice.noteOff(timeStamp.makeRelative(onTime));
    }

    public void playC(){
        freq = 261.63;
        voice.noteOn(freq, 0.5, timeStamp);
        voice.noteOff(timeStamp.makeRelative(onTime));
    }

    public void playD(){
        freq = 293.66;
        voice.noteOn(freq, 0.5, timeStamp);
        voice.noteOff(timeStamp.makeRelative(onTime));
    }

    public void playE(){
        freq = 329.63;
        voice.noteOn(freq, 0.5, timeStamp);
        voice.noteOff(timeStamp.makeRelative(onTime));
    }

    public void playF(){
        freq = 349.23;
        voice.noteOn(freq, 0.5, timeStamp);
        voice.noteOff(timeStamp.makeRelative(onTime));
    }

    public void playG(){
        freq = 392.00;
        voice.noteOn(freq, 0.5, timeStamp);
        voice.noteOff(timeStamp.makeRelative(onTime));
    }

    public void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How long do you want the song to be?");
        int musicLength = scanner.nextInt();
        double randomDoub;

        synth = JSyn.createSynthesizer();
        synth.getAudioDeviceManager().setSuggestedOutputLatency(0.123);

        synth.add(ugen = new SawtoothOscillator());
        voice = (UnitVoice) ugen;
        synth.add(lineOut = new LineOut());

        voice.getOutput().connect(0, lineOut.input, 0);
        voice.getOutput().connect(0, lineOut.input, 1);

        timeNow = synth.getCurrentTime();
        TimeStamp timeStamp = new TimeStamp(timeNow + 0.5);

        synth.startUnit(lineOut, timeStamp);

        synth.start();

        for (int i = 0; i < musicLength; i++) {

            randomDoub = Math.random();

            if (randomDoub <= 0.13) {
                //chord C method
                System.out.println("1");
            } else if (randomDoub > 0.13 && randomDoub <= 0.26) {
                //chord D method
                System.out.println("2");
            } else if (randomDoub > 0.26 && randomDoub <= 0.34) {
                //chord E method
                System.out.println("3");
            } else if (randomDoub > 0.34 && randomDoub <= 0.54) {
                //chord F method
                System.out.println("4");
            } else if (randomDoub > 0.54 && randomDoub <= 0.74) {
                //chord G method
                System.out.println("5");
            } else if (randomDoub > 0.74 && randomDoub <= 0.87) {
                //chord A method
                System.out.println("6");
            } else if (randomDoub > 0.87 && randomDoub <= 1.00) {
                //chord B method
                System.out.println("7");
            } else {
                System.out.println("this shouldn't happen");
            }

            try {
                System.out.println("Sleep while synthesizing.");
                synth.sleepUntil(timeStamp.getTime() + 2.0);
                System.out.println("Woke up...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synth.stop();
        }
    }
    public static void main(String[] args) {
        new MelodyGenerator().test();
    }
}