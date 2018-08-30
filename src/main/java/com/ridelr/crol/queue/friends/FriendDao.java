/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridelr.crol.queue.friends;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.Optional;

/**
 * @author rfk
 */
public class FriendDao extends JdbcDaoSupport {

    private static final Logger LOG = Logger.getLogger(FriendDao.class);

    private static final String STORE_SQL = " INSERT INTO CROL_QUEUE (DEV_ID,UT, PS_HASH) VALUES (?,?,?) ";

    public FriendDao(DataSource ds) {
        setDataSource(ds);
    }

    public int executeSql(String sql) {
        int ru = getJdbcTemplate().update(sql);
        LOG.info("SQL: " + sql);
        return ru;
    }

    private final String readSQL = "SELECT  LAT,LON,ALT,SPD,CRS,STS,INFO,DTTM,PS_HASH  FROM  DEVICES  WHERE  DEV_ID= ? AND UT= ?";

    public Friend upsert(Friend friend) {
        return friend;
    }


    public Optional<Friend> queryNextForProcess() {
        return Optional.empty();
    }
/*
    public NRLocation readLocation(final NRDevice user) {
        final NRLocation[] loc = new NRLocation[1];
        getJdbcTemplate().query(readSQL, new PreparedStatementSetter() {
                    public void setValues(PreparedStatement ps) throws SQLException {
                        int i = 0;
                        ps.setLong(++i, user.userId);
                        ps.setLong(++i, user.userType);
                    }
                }, new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        int i = 0;
*//*LAT,LON,ALT,SPD,CRS,STS,INFO,DTTM *//*

                        final int lat = (int) (rs.getDouble(++i) * 100000);
                        final int lon = (int) (rs.getDouble(++i) * 100000);
                        final short alt = (short) (rs.getInt(++i));
                        final short spd = (short) (rs.getFloat(++i) * 10);
                        final short crs = (rs.getShort(++i));
                        final String sts = (rs.getString(++i));
                        final String info = (rs.getString(++i));
                        final long dt = rs.getDate(++i).getTime();
                        final String ps_hash = (rs.getString(++i));
                        loc[0] = new NRLocation(lat, lon, alt, spd, crs, dt);
                        user.setPasswordMD5Hash(ps_hash);
                    }
                }
        );
        if (loc[0] != null)
            LOG.info("Fetched " + loc[0]);
        return loc[0];
    }

    public void storeEmptyDevice(final NRDevice device) {
        getJdbcTemplate().update(STORE_SQL, new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                int i = 0;

                ps.setInt(++i, device.userId);
                ps.setInt(++i, device.userType);
                ps.setString(++i, device.getPasswordMD5Hash());
            }
        });
        LOG.info("Stored " + device);
    }

    private final String updateSQL = "update DEVICES set LAT=?,LON=?,ALT=?,SPD=?,CRS=?,STS=?,INFO=?,DTTM=?,PS_HASH=? WHERE  DEV_ID= ? AND UT= ?";

    public void updateDeviceLocation(final NRDevice device, final NRLocation location) {
        //final long startTime = System.currentTimeMillis();
        getJdbcTemplate().update(updateSQL, new PreparedStatementSetter() {
            public void setValues(PreparedStatement ps) throws SQLException {
                int i = 0;
                ps.setDouble(++i, location.lat());
                ps.setDouble(++i, location.lon());
                ps.setShort(++i, location.alt());
                ps.setFloat(++i, location.rspd());
                ps.setShort(++i, location.crs());
                ps.setString(++i, device.sts);
                ps.setString(++i, device.getInfo());
                ps.setTimestamp(++i, new Timestamp(location.dt()));
                ps.setString(++i, device.getPasswordMD5Hash());

                ps.setInt(++i, device.userId);
                ps.setInt(++i, device.userType);
            }
        });
        //LOG.info("Updated pos (" + (System.currentTimeMillis() - startTime) + "ms) for " + device.userId + ":" + device.userType);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Pos updated for device " + device);
        }
    }*/
}
