package week3.data;

import week3.model.Worker;

public class WorkerDao {

    public static boolean createWorker(Worker worker) {
        if (worker == null) return false;
        return DataBase.workers.add(worker);
    }

    public static Worker readWorker(int id) {
        if (id <= 0) return null;
        for (int i = 0; i < DataBase.workers.size(); i++) {
            if (DataBase.workers.get(i).getId() == id) return DataBase.workers.get(i);
        }
        return null;
    }

    public static boolean updateWorker(Worker updatedWorker) {
        if (updatedWorker == null || updatedWorker.getId() <=0 ) return false;
        for (int i = 0; i < DataBase.workers.size(); i++) {
            if (DataBase.workers.get(i).getId() == updatedWorker.getId()) {
                DataBase.workers.get(i).setName(updatedWorker.getName());
                DataBase.workers.get(i).setPhoneNumber(updatedWorker.getPhoneNumber());
                DataBase.workers.get(i).setSalary(updatedWorker.getSalary());
                return true;
            }
        }
        return false;
    }

    public static Worker deleteWorker(Worker worker) {
        if (worker == null) return null;
        for (int i = 0; i < DataBase.workers.size(); i++) {
            if (DataBase.workers.get(i).equals(worker)) {
                DataBase.workers.remove(i);
                return worker;
            }
        }
        return null;
    }

}
