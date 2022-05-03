package com.pfa.digitalbankingpfa.web;

import com.pfa.digitalbankingpfa.entities.BankAccount;
import com.pfa.digitalbankingpfa.entities.BankAccountOperation;
import com.pfa.digitalbankingpfa.entities.Client;
import com.pfa.digitalbankingpfa.repo.BankAccOperRepo;
import com.pfa.digitalbankingpfa.repo.BankAccRepo;
import com.pfa.digitalbankingpfa.repo.ClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class ClientController {

    private ClientRepo cliRepo;
    private BankAccRepo BAccRepo;
    private BankAccOperRepo OprRepo;

    @GetMapping(path = "/")
    public String client(Model model,
        @RequestParam(name = "page",defaultValue="0")int page ,
        @RequestParam(name = "size",defaultValue="5")int size,
        @RequestParam(name = "keyword",defaultValue="")String keyword
    ){
            Page<Client> PageC = cliRepo.findByNomContains(keyword,PageRequest.of(page,size));
            model.addAttribute("listC",PageC);
            model.addAttribute("pages",new int[PageC.getTotalPages()]);
            model.addAttribute("currentPage",page);
            model.addAttribute("keyword",keyword);
            return "home";
    }

    @GetMapping("/delete")
    public String delete (Long id, String keyword, int page){
        cliRepo.deleteById(id);
        return "redirect:/?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/details")
    public String detailCli(Long id,Model model){
        List<BankAccount> clientDetails =cliRepo.findById(id).get().getAccounts();
        model.addAttribute("listDetail",clientDetails);
        return "details";
    }

    @GetMapping("/Operation")
    public String detailOperation(String id,Model model){
        List<BankAccountOperation> clientOperationsDetails = BAccRepo.findById(id).get().getOperations();
        model.addAttribute("listOperation",clientOperationsDetails);
        return "operationdetails";
    }

}
