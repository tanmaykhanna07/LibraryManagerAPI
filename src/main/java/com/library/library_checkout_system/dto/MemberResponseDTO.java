package com.library.library_checkout_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MemberResponseDTO {
    @NotNull
    private Integer memberId;
    @NotBlank
    private String name;
    @NotNull
    private boolean isSuspended;
    private Integer noOfBooksBorrowed;

    public MemberResponseDTO(Integer memberId, String name, boolean isSuspended, Integer noOfBooksBorrowed) {
        this.memberId = memberId;
        this.name = name;
        this.isSuspended = isSuspended;
        this.noOfBooksBorrowed = noOfBooksBorrowed;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSuspended() {
        return isSuspended;
    }

    public void setSuspended(boolean suspended) {
        isSuspended = suspended;
    }

    public Integer getNoOfBooksBorrowed() {
        return noOfBooksBorrowed;
    }

    public void setNoOfBooksBorrowed(Integer noOfBooksBorrowed) {
        this.noOfBooksBorrowed = noOfBooksBorrowed;
    }
}
