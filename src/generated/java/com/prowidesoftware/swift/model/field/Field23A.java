/*
 * Copyright 2006-2023 Prowide
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
package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.Generated;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

import java.io.Serializable;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;



import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 23A.
 * <p>
 * Model and parser for field 23A of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: TypeOfSwap: <code>String</code></li>
 * 		<li>Component 2: SettlementMethod: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>10a/5a</code></li>
 * 		<li>parser pattern: <code>S/S</code></li>
 * 		<li>components pattern: <code>SS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2023</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field23A extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2023;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 23A.
	 */
    public static final String NAME = "23A";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_23A = "23A";

    /**
     * @deprecated Use {@link #parserPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase4 = TargetYear.SRU2024)
	public static final String PARSER_PATTERN = "S/S";

    /**
     * @deprecated Use {@link #typesPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase4 = TargetYear.SRU2024)
	public static final String COMPONENTS_PATTERN = "SS";

    /**
     * @deprecated Use {@link #typesPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase4 = TargetYear.SRU2024)
	public static final String TYPES_PATTERN = "SS";

	/**
	 * Component number for the Type Of Swap subfield.
	 */
	public static final Integer TYPE_OF_SWAP = 1;

	/**
	 * @deprecated use #TYPE_OF_SWAP instead
	 */
    @Deprecated
    @ProwideDeprecated(phase4 = TargetYear.SRU2024)
    public static final Integer CODE = 1;

	/**
	 * Component number for the Settlement Method subfield.
	 */
	public static final Integer SETTLEMENT_METHOD = 2;

	/**
	 * @deprecated use #SETTLEMENT_METHOD instead
	 */
    @Deprecated
    @ProwideDeprecated(phase4 = TargetYear.SRU2024)
    public static final Integer ADDITIONAL_INFORMATION = 2;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field23A() {
        super(2);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field23A(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field23A(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "23A")) {
            throw new IllegalArgumentException("cannot create field 23A from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field23A newInstance(Field23A source) {
        Field23A cp = new Field23A();
        cp.setComponents(new ArrayList<>(source.getComponents()));
        return cp;
    }

    /**
     * Create a Tag with this field name and the given value.
     * Shorthand for <code>new Tag(NAME, value)</code>
     * @see #NAME
     * @since 7.5
     */
    public static Tag tag(final String value) {
        return new Tag(NAME, value);
    }

    /**
     * Create a Tag with this field name and an empty string as value.
     * Shorthand for <code>new Tag(NAME, "")</code>
     * @see #NAME
     * @since 7.5
     */
    public static Tag emptyTag() {
        return new Tag(NAME, "");
    }


    /**
     * Parses the parameter value into the internal components structure.
     *
     * <p>Used to update all components from a full new value, as an alternative
     * to setting individual components. Previous component values are overwritten.
     *
     * @param value complete field value including separators and CRLF
     * @since 7.8
     */
    @Override
    public void parse(final String value) {
        init(2);
        setComponent1(SwiftParseUtils.getTokenFirst(value, "/"));
        setComponent2(SwiftParseUtils.getTokenSecondLast(value, "/"));
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        append(result, 1);
        result.append("/");
        append(result, 2);
        return result.toString();
    }

    /**
     * Returns a localized suitable for showing to humans string of a field component.<br>
     *
     * @param component number of the component to display
     * @param locale optional locale to format date and amounts, if null, the default locale is used
     * @return formatted component value or null if component number is invalid or not present
     * @throws IllegalArgumentException if component number is invalid for the field
     * @since 7.8
     */
    @Override
    public String getValueDisplay(int component, Locale locale) {
        if (component < 1 || component > 2) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 23A");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(2);
    }

    /**
     * @deprecated Use {@link #typesPattern()} instead.
     */
    @Override
    @Deprecated
    @ProwideDeprecated(phase4 = TargetYear.SRU2024)
    public String componentsPattern() {
        return "SS";
    }

    /**
     * Returns the field component types pattern.
     * <p>
     * This method returns a letter representing the type for each component in the Field. It supersedes
     * the Components Pattern because it distinguishes between N (Number) and I (BigDecimal).
     * @since 9.2.7
     */
    @Override
    public String typesPattern() {
        return "SS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "S/S";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "10a/5a";
    }

    /**
     * Given a component number it returns true if the component is optional,
     * regardless of the field being mandatory in a particular message.<br>
     * Being the field's value conformed by a composition of one or several
     * internal component values, the field may be present in a message with
     * a proper value but with some of its internal components not set.
     *
     * @param component component number, first component of a field is referenced as 1
     * @return true if the component is optional for this field, false otherwise
     */
    @Override
    public boolean isOptional(int component) {
        return false;
    }

    /**
     * Returns true if the field is a GENERIC FIELD as specified by the standard.
     * @return true if the field is generic, false otherwise
     */
    @Override
    public boolean isGeneric() {
        return false;
    }

    /**
     * Returns the defined amount of components.<br>
     * This is not the amount of components present in the field instance, but the total amount of components
     * that this field accepts as defined.
     * @since 7.7
     */
    @Override
    public int componentsSize() {
        return 2;
    }

    /**
     * Returns english label for components.
     * <br>
     * The index in the list is in sync with specific field component structure.
     * @see #getComponentLabel(int)
     * @since 7.8.4
     */
    @Override
    public List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Type Of Swap");
        result.add("Settlement Method");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "typeOfSwap");
        result.put(2, "settlementMethod");
        return result;
    }

    /**
     * @see Field#getLabelMap()
     * @since 9.3.12
     */
    @Override
    protected Map<String, Integer> getLabelMap() {
        if (super.labelMap != null && !super.labelMap.isEmpty()) {
            // return cached map
            return super.labelMap;
        }
        super.labelMap = new HashMap<>();
        super.labelMap.put("typeofswap", 1);
        // alias name
        super.labelMap.put("code", 1);
        super.labelMap.put("settlementmethod", 2);
        // alias name
        super.labelMap.put("additionalinformation", 2);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Type Of Swap).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Type Of Swap (component 1).
     * @return the Type Of Swap from component 1
     */
    public String getTypeOfSwap() {
        return getComponent1();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Type Of Swap
     * @deprecated use #getTypeOfSwap() instead
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase4 = TargetYear.SRU2024)
    public String getCode() {
        return getTypeOfSwap();
    }

    /**
     * Gets the component 2 (Settlement Method).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Settlement Method (component 2).
     * @return the Settlement Method from component 2
     */
    public String getSettlementMethod() {
        return getComponent2();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Settlement Method
     * @deprecated use #getSettlementMethod() instead
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase4 = TargetYear.SRU2024)
    public String getAdditionalInformation() {
        return getSettlementMethod();
    }

    /**
     * Set the component 1 (Type Of Swap).
     *
     * @param component1 the Type Of Swap to set
     * @return the field object to enable build pattern
     */
    public Field23A setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Type Of Swap (component 1).
     *
     * @param component1 the Type Of Swap to set
     * @return the field object to enable build pattern
     */
    public Field23A setTypeOfSwap(String component1) {
        return setComponent1(component1);
    }

    /**
     * @deprecated use #setTypeOfSwap(String) instead
     */
    @Deprecated
    @ProwideDeprecated(phase4 = TargetYear.SRU2024)
    public Field23A setCode(String component1) {
        return setTypeOfSwap(component1);
    }

    /**
     * Set the component 2 (Settlement Method).
     *
     * @param component2 the Settlement Method to set
     * @return the field object to enable build pattern
     */
    public Field23A setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Settlement Method (component 2).
     *
     * @param component2 the Settlement Method to set
     * @return the field object to enable build pattern
     */
    public Field23A setSettlementMethod(String component2) {
        return setComponent2(component2);
    }

    /**
     * @deprecated use #setSettlementMethod(String) instead
     */
    @Deprecated
    @ProwideDeprecated(phase4 = TargetYear.SRU2024)
    public Field23A setAdditionalInformation(String component2) {
        return setSettlementMethod(component2);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field23A.NAME
     */
    @Override
    public String getName() {
        return NAME;
    }

    /**
     * Gets the first occurrence form the tag list or null if not found.
     * @return null if not found o block is null or empty
     * @param block may be null or empty
     */
    public static Field23A get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field23A(t);
    }

    /**
     * Gets the first instance of Field23A in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field23A get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field23A in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field23A> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field23A from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field23A> getAll(final SwiftTagListBlock block) {
        final List<Field23A> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field23A(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field23A object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field23A fromJson(final String json) {

        final Field23A field = new Field23A();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Type Of Swap

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("code") != null) {
            field.setComponent1(jsonObject.get("code").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("typeOfSwap") != null) {
            field.setComponent1(jsonObject.get("typeOfSwap").getAsString());
        }

        // **** COMPONENT 2 - Settlement Method

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("additionalInformation") != null) {
            field.setComponent2(jsonObject.get("additionalInformation").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("settlementMethod") != null) {
            field.setComponent2(jsonObject.get("settlementMethod").getAsString());
        }

        return field;
    }


}
