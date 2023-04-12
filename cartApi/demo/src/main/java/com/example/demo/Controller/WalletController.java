package com.example.demo.Controller;


        import com.example.demo.Services.WalletService;
        import com.example.demo.model.WalletModel;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping("/{id}")
    public WalletModel getWallet(@PathVariable String id) {

        return walletService.getWallet(id);
    }

    @PostMapping
    public WalletModel createWallet(@RequestBody WalletModel wallet) {

        return walletService.createWallet(wallet);
    }

    @PutMapping("/{id}")
    public WalletModel updateWallet(@PathVariable String id, @RequestBody WalletModel wallet) {
        return walletService.updateWallet(id, wallet);
    }

    @DeleteMapping("/{id}")
    public void deleteWallet(@PathVariable String id) {
        walletService.deleteWallet(id);
    }
}
