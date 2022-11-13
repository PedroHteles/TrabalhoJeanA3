import java.util.*;

public class GarconDao implements Dao<Garcon>, DaoGarcon {

    private ArrayList<Garcon> garcons = new ArrayList<>();


    @Override
    public List<Garcon> getAll() {
        return garcons;
    }

    @Override
    public Optional<Garcon> getGarcom(String email) {

        List<Garcon> garconToList = garcons.stream().filter(e -> Objects.equals(e.getEmail(), email)).toList();
        if (garconToList.size() > 0) {

            return Optional.ofNullable(garconToList.get(0));

        } else {

            return Optional.empty();

        }
    }

    @Override
    public void create(Garcon garcon) {
        garcons.add(new Garcon(garcon.getNome(),
                garcon.getCpf(),
                garcon.getDataNascimento(),
                garcon.getEmail(),
                garcon.getTelefone(),
                garcon.getSexo(),
                garcon.getSalario()
        ));
    }

    @Override
    public void update(Garcon garcon) {

        garcon.setNome(garcon.getNome());
        garcon.setCpf(garcon.getCpf());
        garcon.setDataNascimento(garcon.getDataNascimento());
        garcon.setEmail(garcon.getEmail());
        garcon.setSexo(garcon.getSexo());
        garcon.setSalario(garcon.getSalario());
        garcon.setTelefone(garcon.getTelefone());
        garcons.add(garcon);
    }


    @Override
    public void delete(Garcon garcon) {
        garcons.remove(garcon);
    }


}
