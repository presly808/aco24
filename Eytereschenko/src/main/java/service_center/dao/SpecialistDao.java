package service_center.dao;

import service_center.model.Specialist;
import service_center.utils.Factory;
import service_center.utils.NumberUtils;

public class SpecialistDao implements Dao<Specialist> {

    DbContainer container = Factory.getItem("db");

    @Override
    public boolean create(Specialist specialist) {

        specialist.setId(NumberUtils.generateId());
        return container.specialists.add(specialist);

    }

    @Override
    public Specialist read(String id) {

        return container.specialists.stream().
                filter(n -> n.getId().equals(id)).
                findFirst().orElse(null);

    }

    @Override
    public boolean update(Specialist updatedSpecialist) {

        int indexArr = container.specialists.indexOf(read(updatedSpecialist.getId()));

        if(indexArr == -1){
            return false;
        }

        container.specialists.set(indexArr, updatedSpecialist);

        return true;
    }

    @Override
    public Specialist delete(String id) {

        Specialist specialistToBeDeleted = read(id);
        if(specialistToBeDeleted == null){
            return specialistToBeDeleted;
        }

        container.specialists.remove(specialistToBeDeleted);
        return specialistToBeDeleted;
    }

    @Override
    public Specialist[] all() {

        return container.specialists.toArray(new Specialist[container.specialists.size()]);

    }
}
