package com.library.library_checkout_system.Controllers;

import com.library.library_checkout_system.Services.MemberServices;
import com.library.library_checkout_system.dto.MemberRequestDTO;
import com.library.library_checkout_system.dto.MemberResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libraryApi/member")
class MemberController {
    private final MemberServices memberServices;
    public MemberController(MemberServices memberServices){
        this.memberServices = memberServices;
    }
    @PostMapping
    public MemberResponseDTO registerMember(@Valid @RequestBody MemberRequestDTO memberRequestDTO){
        return memberServices.registerMember(memberRequestDTO);
    }
}
