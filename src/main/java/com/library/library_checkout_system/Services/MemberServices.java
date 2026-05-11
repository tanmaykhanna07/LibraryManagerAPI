package com.library.library_checkout_system.Services;

import com.library.library_checkout_system.Repositories.BookRepository;
import com.library.library_checkout_system.Repositories.MemberRepository;
import com.library.library_checkout_system.dto.MemberRequestDTO;
import com.library.library_checkout_system.dto.MemberResponseDTO;
import com.library.library_checkout_system.models.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberServices {
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    MemberServices(MemberRepository memberRepository, BookRepository bookRepository){
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public  MemberResponseDTO registerMember(MemberRequestDTO memberRequestDTO){
        Member member = new Member();
        member.setName(memberRequestDTO.getName());
        member.setSuspended(false);
        return convertToDTO(memberRepository.save(member));
    }

    public List<MemberResponseDTO> getAllMembers(){
        List<Member> rawMembers = memberRepository.findAll();

        return rawMembers.stream()
                .map(member -> convertToDTO(member))
                .collect(Collectors.toList());
    }

    private MemberResponseDTO convertToDTO(Member newMember){
        return new MemberResponseDTO(
                newMember.getMemberId(),
                newMember.getName(),
                newMember.isSuspended(),
                bookRepository.countBooksByMember(newMember) //make methods in Repositories to counter null pointer exceptions
        );
    }
}

