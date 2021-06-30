package todoly.app.entities;

import java.util.Map;

/**
 * Class that handles the Todos entity.
 *
 * @author Maday Alcala
 * @since 06/29/2021
 */
public class Todo {
    private String name = "";

    /**
     * Gets name.
     *
     * @return Todos's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name - Todos's name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Sets Todos values.
     *
     * @param values - Todos's values information.
     */
    public void setValues(final Map<String, String> values) {
        for (String key: values.keySet()) {
            if (key.equals("name")) {
                setName(values.get("name"));
            }
        }
    }
}
