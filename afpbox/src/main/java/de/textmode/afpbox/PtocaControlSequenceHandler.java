package de.textmode.afpbox;

/*
 * Copyright 2019 Michael Knigge
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
 */

import de.textmode.afpbox.common.PtocaControlSequenceFunctionType;
import de.textmode.afpbox.ptoca.PtocaControlSequence;

/**
 * The {@link PtocaControlSequenceHandler} is responsible for processing the read PTOCA controls sequences.
 */
public interface PtocaControlSequenceHandler {

    /**
     * This method gets called if a {@link PtocaControlSequence} has been read. Note that the given byte[]
     * is backed by the byte[] that has been passed to the {@link PtocaParser}. So with this operation it is
     * possible to modify parsed PTOCA controls sequence.
     *
     * @param functionType   the PTOCA control sequence function type. It is one of the constants of {@link PtocaControlSequenceFunctionType}.
     *                       Note that PTOCA control sequence function type is always the unchained function type (except for GLC and GIR).
     * @param off            offset within the byte[] where the PTOCA control sequence starts.
     * @param data           the raw data of the PTOCA control sequence. Note that the byte[] contains the function type
     *                       and the length in the first two bytes.
     *
     * @return true if the PTOCA control sequence should be parsed. After the PTOCA control sequence has been
     * parsed the method {@link #handleControSequence(PtocaControlSequence)} gets invoked.
     */
    public boolean handleControSequence(final int functionType, final int off, final byte[] data);

    /**
     * This method gets called if a {@link PtocaControlSequence} has been read
     * and {@link #handleControSequence(int, int, byte[])} returned <code>true</code>.
     *
     * @param controlSequence   the read PTOCA control sequence.
     */
    public void handleControSequence(final PtocaControlSequence controlSequence);

    /**
     * This method gets called if a one or more code points have been read.
     *
     * @param codePoints   the read code points.
     */
    public void handleCodePoints(final byte[] codePoints);
}