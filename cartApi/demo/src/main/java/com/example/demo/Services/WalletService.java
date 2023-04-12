


package com.example.demo.Services;




import com.example.demo.Repository.WalletRepository;
import com.example.demo.model.WalletModel;

import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    public List<WalletModel> getAllWallets() {
        return walletRepository.findAll();
    }

    public Optional<WalletModel> getWalletById(String id) {
        return walletRepository.findById(id);
    }

    public WalletModel addWallet(WalletModel wallet) {
        return walletRepository.save(wallet);
    }

    public WalletModel updateWallet(String id, WalletModel wallet) {
        Optional<WalletModel> optionalWallet = walletRepository.findById(id);
        if (optionalWallet.isPresent()) {
            WalletModel existingWallet = optionalWallet.get();
            existingWallet.setBalance(wallet.getBalance());
            existingWallet.setUserId(wallet.getUserId());
            return walletRepository.save(existingWallet);
        }
        return null;
    }

    public void deleteWallet(String id) {
        walletRepository.deleteById(id);
    }

    public void deposit(String id, double amount) {
        Optional<WalletModel> optionalWallet = walletRepository.findById(id);
        if (optionalWallet.isPresent()) {
            WalletModel wallet = optionalWallet.get();
            wallet.setBalance(wallet.getBalance() + amount);
            walletRepository.save(wallet);
        }
    }

    public void withdraw(String id, double amount) {
        Optional<WalletModel> optionalWallet = walletRepository.findById(id);
        if (optionalWallet.isPresent()) {
            WalletModel wallet = optionalWallet.get();
            if (wallet.getBalance() >= amount) {
                wallet.setBalance(wallet.getBalance() - amount);
                walletRepository.save(wallet);
            }
        }
    }

    public WalletModel getWallet(String id) {
        WalletModel walletModel=getWallet(id);
        return walletModel;
    }

    public WalletModel createWallet(WalletModel wallet) {
        WalletModel walletModel=walletRepository.save(wallet);
        return walletModel;
    }
}



