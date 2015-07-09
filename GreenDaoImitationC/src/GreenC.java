import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;


public class GreenC {

	public static void main(String[] args) throws IOException, Exception {
		//数据库版本和生成包路径
		Schema schema = new Schema(1,"com.greenimitation.entity");
		//创建实体及Dao
		addNote(schema);
		//生成Master、Session、Dao及Entity等文件，并指定生成路径
		new DaoGenerator().generateAll(schema, "../GreenAndroidC/src");
	} 
	public static void addNote(Schema schema){
		Entity note = schema.addEntity("book");
		note.addIdProperty().primaryKey().autoincrement();
		note.addStringProperty("name");
		note.addStringProperty("content");
	}
}
