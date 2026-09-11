package com.wms.identity.controller;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired private UserRepository repo;
  @Autowired private JwtUtil jwtUtil;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody User req) {
    User user = repo.findByUsername(req.getUsername())
                    .orElseThrow(() -> new RuntimeException("User not found"));
    if (!user.getPassword().equals(req.getPassword())) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
    return ResponseEntity.ok(token);
  }
}
