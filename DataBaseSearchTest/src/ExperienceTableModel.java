
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * The following class was adapted from luv2code.com to fit into our summer
 * experience project. 
 * @author jacobnehama
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
	private List<Experience> experiences;

	public ExperienceTableModel(List<Experience> theExperiences) {
		experiences = theExperiences;
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

		Experience tempExperiences = experiences.get(row);

		switch (col) {
		case LAST_NAME_COL:
			return tempExperiences.getState();
		case FIRST_NAME_COL:
			return tempExperiences.getCity();
		case EMAIL_COL:
			return tempExperiences.getOrganization();
		case SALARY_COL:
			return tempExperiences.isInternship();
		default:
			return tempExperiences.getState();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
