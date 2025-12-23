@RestController
@RequestMapping("/api/suppliers")
@Tag(name = "Supplier API")
public class SupplierController {

    private final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return service.create(supplier);
    }

    @PutMapping("/{id}")
    public Supplier update(@PathVariable Long id, @RequestBody Supplier supplier) {
        return service.update(id, supplier);
    }

    @GetMapping("/{id}")
    public Supplier get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<Supplier> list() {
        return service.getAll();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivate(id);
    }
}
