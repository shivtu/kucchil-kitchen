package com.example.retail.models.deliveryutility;
import org.springframework.data.domain.Sort;

public class DeliveryLocationsPage {

    private int pageNo = 0;
    private int pageSize = 10;
    private Sort.Direction sortDirection = Sort.Direction.DESC;
    private String sortBy = "deliveryLocationsTableId";

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Sort.Direction getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
