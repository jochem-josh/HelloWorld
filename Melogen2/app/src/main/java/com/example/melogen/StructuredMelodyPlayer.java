/* This Program was made possible through the use of the JSyn sound pack.
 *
 * Copyright 2009 Phil Burk, Mobileer Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * //////////////////////////////////////////////////////////////////////////
 *
 * The purpose of this program is to randomly generate a melody adherent to the rules of
 * music theory within a given key and a given length.
 *
 * Authors: Joshua Jochem, Angela (last name) Zachariah Hunt, Jisoo Kim, and Sangjun (lastname)
 *
 * September 15, 2019
 */
package com.example.melogen;
import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.unitgen.*;
import com.softsynth.shared.time.TimeStamp;
import java.util.Scanner;

public class StructuredMelodyPlayer {
    private Synthesizer synth;
    private UnitGenerator ugen;
    private UnitVoice voice;
    private LineOut lineOut;
    private int musicLength; //how long the song is
    private int startingChord;
    private String keyNote;
    private double key;
    private double BPM;

    long tempo = (long)BPM;
    public StructuredMelodyPlayer(String kNote, int startingNote, int mLength, double beats){
        BPM = 60000/beats;
        key = 0.0;
        keyNote=kNote;
        musicLength=mLength;
        startingChord=startingNote;
    }
    public void play() throws InterruptedException {
        synth = JSyn.createSynthesizer();  // Create a context for the synthesizer.

        synth.add( ugen = new SineOscillator() ); //tone generator

        voice = (UnitVoice) ugen;

        // Add an output mixer.
        synth.add(lineOut = new LineOut());

        // Connect the oscillator to the left and right audio output.
        voice.getOutput().connect(0, lineOut.input, 0);
        voice.getOutput().connect(0, lineOut.input, 1);

        double timeNow = synth.getCurrentTime();// Get synthesizer time in seconds.
        // Advance to a near future time so we have a clean start.
        TimeStamp timeStamp = new TimeStamp(timeNow);
        // We only need to start the LineOut. It will pull data from the oscillator
        synth.startUnit(lineOut, timeStamp);
        // Schedule a note on and off.
        double freq = 200.0; // hertz
        double duration = 0.5;
        double onTime = 1.0;

        synth.start();// Start synthesizer using default stereo output at 44100 Hz.
        voice.noteOn(1, 0.5, timeStamp); //prevents synth from making noise before commanded
        Scanner scanner = new Scanner(System.in); //setting up scanner object
        double randomDouble = Math.random(); //random number generator
        int chord; // determines what chord will be played next

        if (keyNote.equals("C")) key = 261.63;
        else if (keyNote.equals("C#") || keyNote.equals("Db")) key = 277.18;
        else if (keyNote.equals("D")) key = 293.66;
        else if (keyNote.equals("D#") || keyNote.equals("Eb")) key = 311.13;
        else if (keyNote.equals("E")) key = 329.63;
        else if (keyNote.equals("F")) key = 349.23;
        else if (keyNote.equals("F#") || keyNote.equals("Gb")) key = 369.99;
        else if (keyNote.equals("G")) key = 392.0;
        else if (keyNote.equals("G#") || keyNote.equals("Ab")) key = 415.3;
        else if (keyNote.equals("A")) key = 440.0;
        else if (keyNote.equals("A#") || keyNote.equals("Bb")) key = 466.16;
        else if (keyNote.equals("B")) key = 493.88;
        else System.out.println("We love Canada!!!!!!!");


        if (startingChord == 1) chord = 1;
        else if (startingChord == 2) chord = 2;
        else if (startingChord == 3) chord = 3;
        else if (startingChord == 4) chord = 4;
        else if (startingChord == 5) chord = 5;
        else if (startingChord == 6) chord = 6;
        else if (startingChord == 7) chord = 7;

        else {
            // the following if/else statements determine what the first note will be
            if (randomDouble <= 0.13) chord = 1;
            else if (randomDouble > 0.13 && randomDouble <= 0.26) chord = 2;
            else if (randomDouble > 0.26 && randomDouble <= 0.34) chord = 3;
            else if (randomDouble > 0.34 && randomDouble <= 0.54) chord = 4;
            else if (randomDouble > 0.54 && randomDouble <= 0.74) chord = 5;
            else if (randomDouble > 0.74 && randomDouble <= 0.87) chord = 6;
            else chord = 7;
        }

        for (int i = 0; i < musicLength; i++) {
            // this if loops ensures that the last note will always be C
            if (i == musicLength - 1) {
                chord = 1;
            }
            switch (chord) {
                case 1: {
                    freq = key;
                    System.out.println("C");
                    randomDouble = Math.random();
                    if (randomDouble <= 0.13) chord = 1;
                    else if (randomDouble > 0.13 && randomDouble <= 0.26) chord = 2;
                    else if (randomDouble > 0.26 && randomDouble <= 0.34) chord = 3;
                    else if (randomDouble > 0.34 && randomDouble <= 0.54) chord = 4;
                    else if (randomDouble > 0.54 && randomDouble <= 0.74) chord = 5;
                    else if (randomDouble > 0.74 && randomDouble <= 0.87) chord = 6;
                    else chord = 7;
                    if (i == musicLength-2) //ensures proper chord progression
                    {
                        if (randomDouble<=0.50) chord = 5;
                        else chord = 7;
                    }
                    break;
                }
                case 2: {
                    freq = key * 1.12;
                    System.out.println("D");
                    randomDouble = Math.random();
                    if (randomDouble<=0.50) chord = 5;
                    else chord = 7;
                    break;
                }
                case 3: {
                    freq = key * 1.26;
                    System.out.println("E");
                    randomDouble = Math.random();
                    if (randomDouble<=0.50) chord = 4;
                    else chord = 6;
                    if (i == musicLength-3) //ensures proper chord progression
                    {
                        chord = 4;
                    }
                    break;
                }
                case 4: {
                    freq = key * 1.33;
                    System.out.println("F");
                    randomDouble = Math.random();
                    if (randomDouble<=0.33) chord = 2;
                    else if (randomDouble<=0.66) chord = 7;
                    else chord =5;
                    if (i == musicLength-2) //ensures proper chord progression
                    {
                        if (randomDouble<=0.50) chord = 5;
                        else chord = 7;
                    }
                    break;
                }
                case 5: {
                    freq = key * 1.50;
                    System.out.println("G");
                    randomDouble = Math.random();
                    if (randomDouble<=0.50) chord = 1;
                    else chord = 6;
                    break;
                }
                case 6: {
                    freq = key * 1.68;
                    System.out.println("A");
                    randomDouble = Math.random();
                    if (randomDouble<=0.50) chord = 2;
                    else chord = 4;
                    break;
                }
                case 7: {
                    freq = key * 1.89 ;
                    System.out.println("B");
                    chord = 1;
                    break;
                }
                default: {
                    System.out.println("We love Canada!!!!!");
                }
            }
            timeStamp = timeStamp.makeRelative(duration);
            voice.noteOn(freq, 0.5, timeStamp );
            Thread.sleep(tempo);
        }
        voice.noteOff(timeStamp.makeRelative(onTime));
    }
    public static void main(String[] args) throws InterruptedException {
        new StructuredMelodyPlayer().play();
        System.exit(0);
    }
}