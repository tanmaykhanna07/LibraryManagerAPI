package com.library.library_checkout_system.Controllers;

import com.library.library_checkout_system.Services.MemberServices;
import com.library.library_checkout_system.dto.MemberRequestDTO;
import com.library.library_checkout_system.dto.MemberResponseDTO;
import com.library.library_checkout_system.models.Member;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraryApi")
class MemberController {
    private final MemberServices memberServices;
    public MemberController(MemberServices memberServices){
        this.memberServices = memberServices;
    }
    @PostMapping("/newMember")
    public MemberResponseDTO registerMember(@Valid @RequestBody MemberRequestDTO memberRequestDTO){
        return memberServices.registerMember(memberRequestDTO);
    }

    @GetMapping("/members")
    public List<MemberResponseDTO> getAllMembers(){
        return memberServices.getAllMembers();
    }
}
