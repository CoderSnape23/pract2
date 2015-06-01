package com.nashlincoln.blink.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.nashlincoln.blink.model.Timer;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table TIMER.
*/
public class TimerDao extends AbstractDao<Timer, Long> {

    public static final String TABLENAME = "TIMER";

    /**
     * Properties of entity Timer.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Name = new Property(0, String.class, "name", false, "NAME");
        public final static Property Time = new Property(1, String.class, "time", false, "TIME");
        public final static Property Repeat = new Property(2, Boolean.class, "repeat", false, "REPEAT");
        public final static Property RepeatFlags = new Property(3, Integer.class, "repeatFlags", false, "REPEAT_FLAGS");
        public final static Property Id = new Property(4, Long.class, "id", true, "_id");
        public final static Property AttributableId = new Property(5, Long.class, "attributableId", false, "ATTRIBUTABLE_ID");
        public final static Property AttributableType = new Property(6, String.class, "attributableType", false, "ATTRIBUTABLE_TYPE");
    };


    public TimerDao(DaoConfig config) {
        super(config);
    }
    
    public TimerDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'TIMER' (" + //
                "'NAME' TEXT," + // 0: name
                "'TIME' TEXT," + // 1: time
                "'REPEAT' INTEGER," + // 2: repeat
                "'REPEAT_FLAGS' INTEGER," + // 3: repeatFlags
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 4: id
                "'ATTRIBUTABLE_ID' INTEGER," + // 5: attributableId
                "'ATTRIBUTABLE_TYPE' TEXT);"); // 6: attributableType
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TIMER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Timer entity) {
        stmt.clearBindings();
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(1, name);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(2, time);
        }
 
        Boolean repeat = entity.getRepeat();
        if (repeat != null) {
            stmt.bindLong(3, repeat ? 1l: 0l);
        }
 
        Integer repeatFlags = entity.getRepeatFlags();
        if (repeatFlags != null) {
            stmt.bindLong(4, repeatFlags);
        }
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(5, id);
        }
 
        Long attributableId = entity.getAttributableId();
        if (attributableId != null) {
            stmt.bindLong(6, attributableId);
        }
 
        String attributableType = entity.getAttributableType();
        if (attributableType != null) {
            stmt.bindString(7, attributableType);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4);
    }    

    /** @inheritdoc */
    @Override
    public Timer readEntity(Cursor cursor, int offset) {
        Timer entity = new Timer( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // name
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // time
            cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0, // repeat
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // repeatFlags
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // id
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5), // attributableId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // attributableType
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Timer entity, int offset) {
        entity.setName(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setTime(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setRepeat(cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0);
        entity.setRepeatFlags(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setId(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setAttributableId(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
        entity.setAttributableType(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Timer entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Timer entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
