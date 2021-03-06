package de.textmode.afpbox.ptoca;

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

import de.textmode.afpbox.AfpException;
import de.textmode.afpbox.common.ByteUtils;

/**
 * The Overstrike control sequence identifies text that is to be overstruck with a specified character.
 */
public final class Overstrike extends PtocaControlSequence {

    /**
     * Constructs the {@link Overstrike}.
     *
     * @param functionType  the integer value of the PTOCA control sequence function type.
     * @param data          the raw data of the PTOCA control sequence.
     */
    Overstrike(final int functionType, final byte[] data) throws AfpException {
        super(functionType, data, "OVS", 5);
    }

    /**
     * Returns bypass identifiers which specifies which controlled inline white space within
     * the overstrike field is to be overstruck.
     *
     * @return bypass identifiers.
     */
    public int getBypassIdentifiers() {
        return ByteUtils.toUnsignedByte(this.getData(), 2);
    }

    /**
     * Returns the one-byte or two-byte code point that, when coupled with the active
     * coded font, specifies the character to be used for overstriking.
     *
     * @return the one-byte or two-byte code point.
     */
    public int getOverstrikeIdentifiers() {
        return ByteUtils.toUnsignedInteger16(this.getData(), 3);
    }
}
