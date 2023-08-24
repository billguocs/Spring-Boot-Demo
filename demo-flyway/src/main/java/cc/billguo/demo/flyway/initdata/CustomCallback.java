package cc.billguo.demo.flyway.initdata;

import org.flywaydb.core.api.callback.BaseCallback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;


/**
 *
 * @author Bill Guo
 * @date  2023-08-24
 */
public class CustomCallback extends BaseCallback {

    public void beforeMigrate(Context context) {
        // Repeatable
        if (context.getMigrationInfo().getVersion() == null) {
            // Execute your logic for repeatable scripts here
            System.out.println("before");
        }
    }

    public void afterMigrate(Context context) {
        final String VERSIONED = "Versioned";
        String type = context.getMigrationInfo().getType().isBaseline() ? "Baseline" : "Versioned";
        if (VERSIONED.equals(type)) {
            // Execute your logic after versioned scripts here
            System.out.println("after");
        }
    }

    @Override
    public void handle(Event event, Context context) {
        if (event.equals(Event.BEFORE_MIGRATE)) {
            beforeMigrate(context);
        }
        if (event.equals(Event.AFTER_MIGRATE)) {
            afterMigrate(context);
        }
    }
}
