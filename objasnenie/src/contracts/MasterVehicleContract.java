// src/contracts/MasterVehicleContract.java
package contracts;

import company.InsuranceCompany;
import objects.Person;
import objects.LegalForm;
import java.util.LinkedHashSet;
import java.util.Set;

public class MasterVehicleContract extends AbstractVehicleContract {
    private final Set<SingleVehicleContract> childContracts = new LinkedHashSet<>();

    public MasterVehicleContract(String contractNumber, InsuranceCompany insurer,
                                 Person beneficiary, Person policyHolder) {
        super(contractNumber, insurer, beneficiary, policyHolder, null, 0);
        if (policyHolder.getLegalForm() != LegalForm.LEGAL) {
            throw new IllegalArgumentException("Policy holder must be a legal person");
        }
    }

    public Set<SingleVehicleContract> getChildContracts() {
        return childContracts;
    }

    @Override
    public boolean isActive() {
        if (childContracts.isEmpty()) {
            return super.isActive();
        }
        return childContracts.stream().anyMatch(AbstractContract::isActive);
    }

    @Override
    public void setInactive() {
        super.setInactive();
        childContracts.forEach(AbstractContract::setInactive);
    }
}