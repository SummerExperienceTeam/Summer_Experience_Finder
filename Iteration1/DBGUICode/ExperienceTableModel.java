
import java.util.List;

import javax.swing.table.AbstractTableModel;
/**
 * This table model is adapted from luv2code.com, and was slightly adapted
 * to process our database. These files are mostly getters and setters
 * aside from the String array of column names. 
 * @author Jacob and Pietro
 *
 */

class ExperienceTableModel extends AbstractTableModel {

	private static final int LAST_NAME_COL = 0;
	private static final int FIRST_NAME_COL = 1;
	private static final int EMAIL_COL = 2;
	private static final int SALARY_COL = 3;

	private String[] columnNames = { "international",  "internship",  "organization",  "state",  "city",
			 "natureOfWork",  "addtionalInformation",  "hoursPerWeek",  "standing",
			 "compensation",  "activity" };
	private List<jacobExperience> experiences;

	public ExperienceTableModel(List<jacobExperience> experience) {
		experiences = experience;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return experiences.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		jacobExperience tempExperience = experiences.get(row);

		switch (col) {
		case LAST_NAME_COL:
			return tempExperience.getState();
		case FIRST_NAME_COL:
			return tempExperience.getCity();
		case EMAIL_COL:
			return tempExperience.getOrganization();
		case SALARY_COL:
			return tempExperience.isInternship();
		default:
			return tempExperience.getState();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
