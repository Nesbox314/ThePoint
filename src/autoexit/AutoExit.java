package autoexit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import markers.Hour;
import markers.Mark;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AutoExit
{

	static public ArrayList<Hour> getListHours()
	{
		ArrayList<Hour> listaDeHoras = new ArrayList<>();
		ArrayList<Mark> resultFromJson = new ArrayList<>();
		try
		{
			String CREDENTIAL = Credentials.basic("ponto", "PONTO");
			OkHttpClient client = new OkHttpClient();

			Request request = new Request.Builder().url(
					"http://romenia/wpe/api/Marcacao" + "/" + "142.68047.58.8" + "/" + new SimpleDateFormat(
						"yyyy-MM-dd").format(new GregorianCalendar().getTime()))
				.addHeader("Content-Type", "application/json").addHeader("Authorization", CREDENTIAL)
				.method("GET", null).build();
			Response response = client.newCall(request).execute();

			try
			{
				Gson gson = new GsonBuilder().create();
				Type type = new TypeToken<ArrayList<Mark>>(){}.getType();
				resultFromJson = gson.fromJson(response.body().string(), type);
			}
			catch (Exception e)
			{
				System.out.println("Houve alguma falha ao pegar os dados!");
			}

			for (Mark marcacao : resultFromJson)
			{
				Hour hour = new Hour();
				hour.setHoras(Integer.parseInt(marcacao.getHora()));
				hour.setMinutos(Integer.parseInt(marcacao.getMinuto()));
				listaDeHoras.add(hour);
			}
		}
		catch (Exception e)
		{
			System.out.println("Houve alguma falha ao pegar os dados!");
		}

		return listaDeHoras;
	}
}
