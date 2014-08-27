package com.fks.pwm.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_task database table.
 * 
 */
@Entity
@Table(name="mst_task")
@NamedQuery(name="MstTask.findAll", query="SELECT m FROM MstTask m")
public class MstTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="task_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long taskId;

	@Column(name="is_blocked")
	private byte isBlocked;

	@Column(name="task_name")
	private String taskName;

	//bi-directional many-to-one association to TransTask
	@OneToMany(mappedBy="mstTask")
	private List<TransTask> transTasks;

	public MstTask() {
	}

	public Long getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public byte getIsBlocked() {
		return this.isBlocked;
	}

	public void setIsBlocked(byte isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public List<TransTask> getTransTasks() {
		return this.transTasks;
	}

	public void setTransTasks(List<TransTask> transTasks) {
		this.transTasks = transTasks;
	}

	public TransTask addTransTask(TransTask transTask) {
		getTransTasks().add(transTask);
		transTask.setMstTask(this);

		return transTask;
	}

	public TransTask removeTransTask(TransTask transTask) {
		getTransTasks().remove(transTask);
		transTask.setMstTask(null);

		return transTask;
	}

}