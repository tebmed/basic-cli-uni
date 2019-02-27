package fr.pantheonsorbonne.ufr27.entity;

public class Course extends EducationEntity {

	public Course(String name) {
		super(name);
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode();

	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Course) {
			return ((Course) o).getName().equals(this.getName());
		} else {
			return false;
		}
	}

	private boolean taught = false;

	public void starts() {
		taught = true;

	}

	public boolean isTaught() {
		return this.taught;
	}
}
