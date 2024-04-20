package com.example.ExcleRBackEndCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Broker")
 class BrokerController {
    @Autowired
    private BrokerRepository brokerRepository;

    @PostMapping("/Signup")
    public Broker signUp(@RequestBody Broker broker) {
        return brokerRepository.save(broker);
    }

    @PostMapping("/Login")
    public ResponseEntity<String> login(@RequestBody Broker loginBroker) {
        Optional<Broker> brokerOptional = brokerRepository.findByEmail(loginBroker.getEmail());
        if (brokerOptional.isPresent()) {
            Broker broker = brokerOptional.get();
            if (broker.getPassword().equals(loginBroker.getPassword())) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Broker not found");
        }
    }
}

@RestController
@RequestMapping("/Property")
 class PropertyController {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyService propertyService;

    @PostMapping("/Add")
    public Property addProperty(@RequestBody Property property) {
        return propertyRepository.save(property);
    }

    @GetMapping("/{prop_id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long prop_id) {
        Optional<Property> propertyOptional = propertyRepository.findById(prop_id);
        return propertyOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/broker/{brokerId}")
    public List<Property> getPropertiesByBrokerId(@PathVariable Long brokerId) {
        return propertyRepository.findByBrokerId(brokerId);
    }
    @GetMapping("/filtertypes/{type}")
    public List<Property> getPropertiesByType(@PathVariable String type) {
        return propertyRepository.findByType(type);
    }
    
	public PropertyService getPropertyService() {
		return propertyService;
	}

	public void setPropertyService(PropertyService propertyService) {
		this.propertyService = propertyService;
	}
}
@RestController
@RequestMapping("/User")
public class RealEstateController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/Signup")
    public User signUp(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/Login")
    public ResponseEntity<String> login(@RequestBody User loginUser) {
        Optional<User> userOptional = userRepository.findByEmail(loginUser.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(loginUser.getPassword())) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }
    }
}

@RestController
@RequestMapping("/user_status")
 class user_statusController {
    @Autowired
    private user_statusRepository userstRepository;
    @Autowired
    private user_statusService userstService;

    @PostMapping("/Add")
    public user_status addUser_status(@RequestBody user_status userst) {
        return userstRepository.save(userst);
    }

    @GetMapping("{brokerId}")
    public List<user_status> getPropertiesByBrokerId(@PathVariable Long brokerId) {
        return userstRepository.findByBrokerId(brokerId);
    }
 
    

	public user_statusService getuser_statusService() {
		return userstService;
	}

	public void setPropertyService(user_statusService userstService) {
		this.userstService = userstService;
	}
}

@RestController
@RequestMapping("/Admin")
 class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/Signup")
    public Admin signUp(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    @PostMapping("/Login")
    public ResponseEntity<String> login(@RequestBody Admin loginAdmin) {
        Optional<Admin> adminOptional = adminRepository.findByEmail(loginAdmin.getEmail());
        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            if (admin.getPassword().equals(loginAdmin.getPassword())) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Broker not found");
        }
    }
}