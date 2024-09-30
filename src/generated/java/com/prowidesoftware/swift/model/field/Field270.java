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

import java.util.Calendar;

import com.prowidesoftware.swift.model.field.DateContainer;
import com.prowidesoftware.swift.model.field.DateResolver;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 270.
 * <p>
 * Model and parser for field 270 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Timestamp: <code>Calendar</code></li>
 * 		<li>Component 2: LoginBlock: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;YYMMDDHHMM&gt;&lt;?&gt;</code></li>
 * 		<li>parser pattern: <code>10!NS</code></li>
 * 		<li>components pattern: <code>US</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2023</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field270 extends Field implements Serializable, DateContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2023;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 270.
	 */
    public static final String NAME = "270";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_270 = "270";

    /**
     * @deprecated Use {@link #parserPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase4 = TargetYear.SRU2024)
	public static final String PARSER_PATTERN = "10!NS";

    /**
     * @deprecated Use {@link #typesPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase4 = TargetYear.SRU2024)
	public static final String COMPONENTS_PATTERN = "US";

    /**
     * @deprecated Use {@link #typesPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase4 = TargetYear.SRU2024)
	public static final String TYPES_PATTERN = "US";

	/**
	 * Component number for the Timestamp subfield.
	 */
	public static final Integer TIMESTAMP = 1;

	/**
	 * Component number for the Login Block subfield.
	 */
	public static final Integer LOGIN_BLOCK = 2;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field270() {
        super(2);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field270(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field270(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "270")) {
            throw new IllegalArgumentException("cannot create field 270 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field270 newInstance(Field270 source) {
        Field270 cp = new Field270();
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
        if (value != null) {
            if (value.length() >= 10) {
                setComponent1(StringUtils.substring(value, 0, 10));
            }
            if (value.length() > 10) {
                setComponent2(StringUtils.substring(value, 10));
            }
        }
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        result.append(joinComponents());
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 270");
        }
        if (component == 1) {
            //datetime: [YY]YYMMDDHHMM
            java.text.DateFormat df = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
            java.text.DateFormat tf = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
            java.util.Calendar cal = getComponent1AsCalendar();
            if (cal != null) {
                return df.format(cal.getTime()) + " " + tf.format(cal.getTime());
            }
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
        return "US";
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
        return "US";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "10!NS";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "<YYMMDDHHMM><?>";
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
        result.add("Timestamp");
        result.add("Login Block");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "timestamp");
        result.put(2, "loginBlock");
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
        super.labelMap.put("timestamp", 1);
        super.labelMap.put("loginblock", 2);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Timestamp).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Get the component 1 as Calendar
     *
     * @return the component 1 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent1AsCalendar() {
        return SwiftFormatUtils.getDateTimeShortYear(getComponent(1));
    }

    /**
     * Gets the Timestamp (component 1).
     * @return the Timestamp from component 1
     */
    public String getTimestamp() {
        return getComponent1();
    }

    /**
     * Get the Timestamp (component 1) as Calendar
     * @return the Timestamp from component 1 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getTimestampAsCalendar() {
        return getComponent1AsCalendar();
    }

    /**
     * Gets the component 2 (Login Block).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Login Block (component 2).
     * @return the Login Block from component 2
     */
    public String getLoginBlock() {
        return getComponent2();
    }

    /**
     * Set the component 1 (Timestamp).
     *
     * @param component1 the Timestamp to set
     * @return the field object to enable build pattern
     */
    public Field270 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component1 from a Calendar object.
     *
     * @param component1 the Calendar with the Timestamp content to set
     * @return the field object to enable build pattern
     */
    public Field270 setComponent1(java.util.Calendar component1) {
        setComponent(1, SwiftFormatUtils.getDateTimeShortYear(component1));
        return this;
    }

    /**
     * Set the Timestamp (component 1).
     *
     * @param component1 the Timestamp to set
     * @return the field object to enable build pattern
     */
    public Field270 setTimestamp(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the Timestamp (component 1) from a Calendar object.
     *
     * @see #setComponent1(java.util.Calendar)
     *
     * @param component1 Calendar with the Timestamp content to set
     * @return the field object to enable build pattern
     */
    public Field270 setTimestamp(java.util.Calendar component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Login Block).
     *
     * @param component2 the Login Block to set
     * @return the field object to enable build pattern
     */
    public Field270 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Login Block (component 2).
     *
     * @param component2 the Login Block to set
     * @return the field object to enable build pattern
     */
    public Field270 setLoginBlock(String component2) {
        return setComponent2(component2);
    }


    /**
     * Returns all components that can be converted to a Calendar
     *
     * @return the list of converted components (a Calendar object or null)
     * @since 9.2.7
     */
    @Override
    public List<Calendar> dates() {
        return DateResolver.dates(this);
    }

    /**
     * Returns the first component that can be converted to a Calendar
     *
     * @return the converted components (a Calendar object or null)
     * @since 9.2.7
     */
    public Calendar date() {
        return DateResolver.date(this);
    }


    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field270.NAME
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
    public static Field270 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field270(t);
    }

    /**
     * Gets the first instance of Field270 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field270 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field270 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field270> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field270 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field270> getAll(final SwiftTagListBlock block) {
        final List<Field270> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field270(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field270 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field270 fromJson(final String json) {

        final Field270 field = new Field270();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Timestamp

        if (jsonObject.get("timestamp") != null) {
            field.setComponent1(jsonObject.get("timestamp").getAsString());
        }

        // **** COMPONENT 2 - Login Block

        if (jsonObject.get("loginBlock") != null) {
            field.setComponent2(jsonObject.get("loginBlock").getAsString());
        }

        return field;
    }


}
