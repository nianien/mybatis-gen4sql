package com.baomidou.mybatisplus.generator.samples;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig.Builder;
import com.baomidou.mybatisplus.generator.query.DefaultQuery;
import lombok.SneakyThrows;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * H2 代码生成
 *
 * @author liyifei
 */
public class CodeGeneratorTest {


    @Test
    @SneakyThrows
    public void test() {
        Builder builder = new Builder("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;CASE_INSENSITIVE_IDENTIFIERS=TRUE;MODE=MYSQL", "sa", "")
                .databaseQueryClass(DefaultQuery.class);
        Connection connection = builder.build().getConn();
        ScriptRunner scriptRunner = new ScriptRunner(connection);
        scriptRunner.setAutoCommit(true);
        File[] sqlFiles = new File("./src/main/resources/sql").listFiles();
        for (File sqlFile : sqlFiles) {
            scriptRunner.runScript(new InputStreamReader(new FileInputStream(sqlFile)));
        }
        List<String> schemas = getStrings(connection);

        for (String schema : schemas) {
            gen("com.katana.demo", schema,
                    "./src/main/java");
        }

    }

    @NotNull
    private static List<String> getStrings(Connection connection) throws SQLException {
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        List<String> schemas = new ArrayList<>();
        try (ResultSet resultSet = databaseMetaData.getSchemas()) {
            while (resultSet.next()) {
                String schema = resultSet.getString("TABLE_SCHEM");
                if ("INFORMATION_SCHEMA".equalsIgnoreCase(schema) || "PUBLIC".equalsIgnoreCase(schema)) {
                    continue;
                }
                schemas.add(schema);
            }
        } catch (SQLException e) {
            throw new RuntimeException("读取数据库表信息出现错误", e);
        }
        return schemas;
    }

    /**
     * 更改模板生成的文件路径
     *
     * @see OutputFile
     */

    @SneakyThrows
    public void gen(String packageName, String schema, String outputDir) {
        DataSourceConfig dataSourceConfig =
                new Builder("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;CASE_INSENSITIVE_IDENTIFIERS=TRUE;MODE=MYSQL", "sa", "")
                        .databaseQueryClass(DefaultQuery.class)
                        .schema(schema)
                        .build();
        // 设置自定义路径
        AutoGenerator generator = new AutoGenerator(dataSourceConfig);
        generator.strategy(
                new StrategyConfig.Builder()
                        //表名带schema
                        .enableSchema()
                        //忽略视图
                        .enableSkipView()
                        /*
                        // 过滤表前缀
                        .addTablePrefix("t_", "c_")
                        // 过滤表后缀
                        .addFieldSuffix("_flag")
                        .entityBuilder()
                        //新增@Version注解
                        .versionColumnName("version") // 基于数据库字段
                        .versionPropertyName("version")// 基于模型属性
                        //新增@TableField(value = "xxx", fill = FieldFill.xxx)注解
                        .addTableFills(new Column("create_time", FieldFill.INSERT))    //基于数据库字段填充
                        .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))    //基于模型属性填充
                        //新增@TableLogic注解
                        .logicDeleteColumnName("deleted") // 基于数据库字段
                        .logicDeletePropertyName("deleteFlag")// 基于模型属性
                        .addIgnoreColumns("age") // 基于数据库字段
                        */
                        .build()
        );
        generator.packageInfo(
                new PackageConfig.Builder()
                        //设置xml与mapper相同的目录,默认.xml("mapper/xml")
                        .xml("mapper")
                        //指定包名
                        .parent(packageName + "." + schema.toLowerCase()).build()
        );
        generator.global(
                new GlobalConfig.Builder()
                        // 不打开输出目录
                        .disableOpenDir()
                        .outputDir(outputDir)
                        .build()
        );
        generator.execute();
    }

}
